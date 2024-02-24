донации (username в query)
GET /api/donations/ - получение списка донаций (DonationsDTO)  (query params limit and page, скорее всего не понадобится но сделаем)
GET /api/donations/{id}/ - получение одной донации (Donations)
POST /api/donations/ - создание донации (Donations)
PUT /api/donations/{id}/ - редактирование донации (Donations)
DELETE /api/donation/{id}/ - удаление донации (Donation) Response - { id }

Планируемые донации (username в query)
GET /api/donation_plan/ получение списка планируемых донаций (DonationsPlan DTO)  (query params limit and page, скорее всего не понадобится но сделаем)
GET /api/donations_plan/{id}/ - получение одной планируемой донации (DonationsPlan)
POST /api/donations_plan/ - создание планируемой донации (Donations)
PUT /api/donation_plan/ - редактирование планируемой донации (Donations)
DELETE /api/donation_plan/{id}/ - удаление донации (Donation) Response - { id }

Центры крови 
GET /api/blood_center/user/ { query: bloodGroup, cityId, regionId: 'id'/'' (искать в регионе) } (BloodCenterDTO) получение списков центров 
GET /api/blood_center/{id}/ (BloodCenter) 
GET /api/blood_center/ {query: page} Список центров донаций в городе 

Поиск городов
GET /api/city/ {query: query_str: string (кусок города от пользователя)} (City)

Юзер
PUT /user изменение данных пользователя




