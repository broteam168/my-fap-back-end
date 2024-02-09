package broteam.myfap.backend.Dto.Unit;

import broteam.myfap.backend.Models.Enums.BuildingName;
import broteam.myfap.backend.Models.Enums.RoomType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RoomRequestDto {

    private String Name;

    private String Description;

    private RoomType Type;
    private BuildingName Building;
    private int SchoolId;
    private boolean IsActive;
}
