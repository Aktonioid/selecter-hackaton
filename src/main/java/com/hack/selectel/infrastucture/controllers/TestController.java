package com.hack.selectel.infrastucture.controllers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import com.hack.selectel.core.models.BloodComponentsStatus;
import com.hack.selectel.core.models.BloodGroupStatus;
import com.hack.selectel.core.models.City;
import com.hack.selectel.core.models.DonationCenter;
import com.hack.selectel.core.models.DonationCenterPhones;
import com.hack.selectel.core.models.Region;
import com.hack.selectel.core.models.ScheduleModel;
import com.hack.selectel.infrastucture.repositories.CityRepo;
import com.hack.selectel.infrastucture.repositories.DonationCenterRepository;
import com.hack.selectel.infrastucture.repositories.RegionRepository;
import com.hack.selectel.infrastucture.repositories.ScheduleRepository;

@RestController
@RequestMapping("test")
@PropertySource("application.properties")
public class TestController 
{
    @Autowired
    Environment env;
    @Autowired
    RegionRepository repository;
    @Autowired
    CityRepo citiesRepository;
    @Autowired
    ScheduleRepository scheduleRepository;
    @Autowired
    DonationCenterRepository donationCenterRepository;

    @GetMapping("/get")
    public ResponseEntity<String> sendToTelegram(String chatId)
    {
        SendMessage message = new SendMessage();

        message.setChatId(chatId);
        message.setText("ОЛАРОЛЫВЛАЫЛОРАЛО");

        String token = env.getProperty("telegram.bot-token");

        Delete delete = new Delete(token);

        try {
            delete.sendMessage(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok("di");
    }

    @GetMapping("/test")
    public ResponseEntity<List<City>> httpConnectionTest() throws IOException, InterruptedException
    {
        List<City> cities = new ArrayList<>();
        for(int j = 1; j <= 1271; j++)
        {
            HttpRequest request = HttpRequest.newBuilder()
                                    .uri(URI.create("https://hackaton.donorsearch.org/api/cities/?page="+j))
                                    .GET()
                                    .build();

            HttpClient client = HttpClient.newHttpClient();

            //1271 страница городов

            HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
            System.out.println(response.toString());
            // System.out.println(response.body());
            JSONObject jsonObject = new JSONObject(response.body());
            // System.out.println("Json Array "+ jsonObject.getJSONArray("results"));
            JSONArray array = jsonObject.getJSONArray("results");
            
            for(int i = 0; i < array.length(); i++)
            {
                JSONObject json = array.getJSONObject(i);
                cities.add(parseCities(json));
            }
        }
        for(int i =0; i < cities.size(); i++)
        {
            citiesRepository.CreateCity(cities.get(i));
        }
        return ResponseEntity.ok(cities);
    }

    private City parseCities(JSONObject json)
    {
        JSONObject regionJson = null;
        // System.out.println(json);
        // System.out.println("\n\n\n");
        try
        {
            regionJson = json.getJSONObject("region");
        }
        catch(JSONException e)
        {
            
        }
        Region region = null;

        if(regionJson != null)
        {
            region = new Region(regionJson.getInt("id"));   
            
        }
        City city = new City
                    (
                        json.getInt("id"),
                        json.getString("title"),
                        region
                    );
        return city;
    }

    @PostMapping
    public ResponseEntity<List<Region>> CreateRegions() throws IOException, InterruptedException
    {
        List<Region> regions = new ArrayList<>();
        for(int i = 1; i<=9;i++)
        {
            
            HttpRequest request = HttpRequest.newBuilder()
                                    .uri(URI.create("https://hackaton.donorsearch.org/api/regions/?page="+i))
                                    .GET()
                                    .build();

            HttpClient client = HttpClient.newHttpClient();


            HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
            System.out.println(response.toString());
            // System.out.println(response.body());
            JSONObject jsonObject = new JSONObject(response.body());
            //max page = 9
            JSONArray array = jsonObject.getJSONArray("results");
            for(int j = 0; j < array.length(); j++)
            {
                regions.add(parseRegions(array.getJSONObject(j)));
            }
        }
        for(int i = 0; i < regions.size();i++)
        {
            repository.CreateRegion(regions.get(i));
        }
        return ResponseEntity.ok(regions);
    }
    private Region parseRegions(JSONObject json)
    {
        return new Region(json.getInt("id"), json.getString("title"));
    }

    @GetMapping("/sched")
    public ResponseEntity<List<DonationCenter>> CreateDonationCenters() throws IOException, InterruptedException
    {
        //max page = 22
        List<DonationCenter> centers = new ArrayList<>();
        List<ScheduleModel> scheds = new ArrayList<>();
        List<DonationCenterPhones> phones = new ArrayList<>();

        for(int j =1; j <=22; j++)
        {
            HttpRequest request = HttpRequest.newBuilder()
                                    .uri(URI.create("https://hackaton.donorsearch.org/api/blood_stations/?page="+j))
                                    .GET()
                                    .build();

            HttpClient client = HttpClient.newHttpClient();


            HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
            // System.out.println(response.toString());
            // System.out.println(response.body());
            JSONObject jsonObject = new JSONObject(response.body());
            //max page = 9
            JSONArray array = jsonObject.getJSONArray("results");
            for(int i = 0; i < array.length(); i++)
            {
                JSONObject json = array.getJSONObject(i);
                centers.add(parseCenter(json));
                int center_id = json.getInt("id");
                JSONArray schedArray = json.getJSONArray("schedule");
                System.out.println(schedArray.length());
                System.out.println();

                for(int k = 0; k < schedArray.length(); k++)
                {
                    try
                    {
                        scheds.add(parseSceduleFromCenter(schedArray.getJSONObject(i), center_id));
                    }
                    catch(JSONException e)
                    {
                        break;
                    }
                }

                JSONArray phonesArray = json.getJSONArray("phone_numbers");

                for(int k = 0; k < phonesArray.length(); k++)
                {
                    JSONObject phone = phonesArray.getJSONObject(k);
                    try
                    {
                        phones.add(new DonationCenterPhones(phone.getInt("id"), phone.getString("phone"), new DonationCenter(center_id)));
                    }
                    catch(JSONException e)
                    {
                        break;
                    }
                }
                // regions.add(parseRegions(array.getJSONObject(j)));
            }
        }

        for(int i = 0; i < centers.size(); i++)
        {
            donationCenterRepository.CreateDonationCenter(centers.get(i));
        }

        // for(int i = 0; i < scheds.size(); i++)
        // {
        //     scheduleRepository.CreateSchedule(scheds.get(i));
        // }

        return ResponseEntity.ok(centers);
    }

    private DonationCenter parseCenter(JSONObject json)
    {
        // System.out.println(json);
        // System.out.println("\n\n\n");
        JSONObject cityJson = json.getJSONObject("city");

        

        return new DonationCenter(
            json.getInt("id"),
            new City(cityJson.getInt("id")),
            json.getString("title"),
            json.getString("address"),
            json.getString("site"),
            null,
            new HashSet<ScheduleModel>(),
            MapBloodGroupStatus(json.getString("o_plus")),
            MapBloodGroupStatus(json.getString("o_minus")),
            MapBloodGroupStatus(json.getString("a_plus")),
            MapBloodGroupStatus(json.getString("a_minus")),
            MapBloodGroupStatus(json.getString("b_plus")),
            MapBloodGroupStatus(json.getString("b_minus")),
            MapBloodGroupStatus(json.getString("ab_plus")),
            MapBloodGroupStatus(json.getString("ab_minus")),
            MapBloodComponentsStatus(json.getString("blood")),
            MapBloodComponentsStatus(json.getString("plasma")),
            MapBloodComponentsStatus(json.getString("platelets")),
            MapBloodComponentsStatus(json.getString("erythrocytes")),
            MapBloodComponentsStatus(json.getString("leukocytes"))
        );
    }
    
    private BloodGroupStatus MapBloodGroupStatus(String stringStatus)
    {
        BloodGroupStatus status = null;
        
        switch (stringStatus) 
        {
            case "unknown" -> status = BloodGroupStatus.UNKOWN;
            case "need" -> status = BloodGroupStatus.NEED;
            case "no_need" -> status = BloodGroupStatus.NO_NEED;
            default -> status = BloodGroupStatus.UNKOWN;
        }
        
        return status;
    }


    private BloodComponentsStatus MapBloodComponentsStatus(String stringStatus)
    {
        BloodComponentsStatus status = null;

        switch (stringStatus) 
        {
            case "unknown" -> status = BloodComponentsStatus.UNKOWN;
            case "accept" -> status = BloodComponentsStatus.ACCEPT;
            case "no_accept" -> status = BloodComponentsStatus.NO_ACCEPT;
            default -> status = BloodComponentsStatus.UNKOWN;
        }

        return status;
    }
    //суда приходит json одного расписания и id центра
    private ScheduleModel parseSceduleFromCenter(JSONObject scheduleJson, int centerId)
    {
        return new ScheduleModel(scheduleJson.getInt("id"),
                    scheduleJson.getString("dow"),
                    scheduleJson.getString("start"),
                    scheduleJson.getString("end"),
                    new DonationCenter(centerId));
    }
}
