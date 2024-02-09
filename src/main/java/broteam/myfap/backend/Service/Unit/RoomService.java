package broteam.myfap.backend.Service.Unit;

import broteam.myfap.backend.Converter.Unit.UnitConverter;
import broteam.myfap.backend.Dto.Major.SubMajorDto;
import broteam.myfap.backend.Dto.Unit.ClassDto;
import broteam.myfap.backend.Dto.Unit.RoomDto;
import broteam.myfap.backend.Models.Major.SubMajor;
import broteam.myfap.backend.Models.Unit.Class;
import broteam.myfap.backend.Models.Unit.Room;
import broteam.myfap.backend.Models.Unit.School;
import broteam.myfap.backend.Repository.Unit.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomService implements IRoomService {
    private final RoomRepository roomRepository;
    private final UnitConverter unitConverter;
    @Override
    public List<RoomDto> findAllBase() {

        List<RoomDto> results = new ArrayList<>();
        for (Room item : roomRepository.findAll()) {
            results.add(unitConverter.toDto(item));
        }
        return results;
    }

    @Override
    public List<RoomDto> FindBySchoolId(int id) {
        List<RoomDto> results = new ArrayList<>();

        List<Room> enitities = roomRepository.findBySchoolId(id);
        for(Room enitity : enitities)
        {
            results.add(unitConverter.toDto(enitity));
        }
        return results;
    }
}
