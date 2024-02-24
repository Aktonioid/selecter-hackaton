export interface ICity {
    id: number;
    title: string;
    region: IRegion;
}

export interface IRegion {
    id: number;
    title: string;
}