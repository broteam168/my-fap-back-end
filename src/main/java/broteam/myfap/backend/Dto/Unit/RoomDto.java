package broteam.myfap.backend.Dto.Unit;

import broteam.myfap.backend.Models.Enums.BuildingName;
import broteam.myfap.backend.Models.Enums.RoomType;

public class RoomDto {
    private int id;

    private String Name;

    private String Description;

    private RoomType Type;
    private BuildingName Building;
    private boolean IsActive;
}
