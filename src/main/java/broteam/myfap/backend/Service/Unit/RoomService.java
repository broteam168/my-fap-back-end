package broteam.myfap.backend.Service.Unit;

import broteam.myfap.backend.Converter.Unit.UnitConverter;
import broteam.myfap.backend.Dto.Unit.RoomDto;
import broteam.myfap.backend.Dto.Unit.RoomRequestDto;
import broteam.myfap.backend.Exception.Unit.SchoolException;
import broteam.myfap.backend.Models.Unit.Room;
import broteam.myfap.backend.Repository.Unit.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RoomService implements IRoomService {
    private final RoomRepository roomRepository;
    private final UnitConverter unitConverter;
    private final ModelMapper modelMapper = new ModelMapper();

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

    @Transactional
    @Override
    public RoomDto createNewRoom(RoomRequestDto newRoom) {
        Room baseRoom = modelMapper.map(newRoom, Room.class);

        Optional<Room> duplicate = roomRepository.findByName(baseRoom.getName());
        if (duplicate.stream().count() > 0) {
            throw new SchoolException("Room name is already used");
        }
        Room createdClass = roomRepository.save(baseRoom);
        return unitConverter.toDto(createdClass);
    }

    @Transactional
    @Override
    public RoomDto updateRoom(int id, RoomRequestDto newRoom) {
        Room baseClass = modelMapper.map(newRoom, Room.class);

        Optional<Room> duplicate2 = roomRepository.findById(id);
//        Optional<Class> duplicate = classRepository.findByName(baseClass.getName());
//        if (newCLass.getName().equals(duplicate2.get().getName()) && duplicate.stream().count() > 0) {
//            throw new SchoolException("Class name is already used");
//        }
        if (duplicate2.stream().count() > 0) {
            baseClass.setId(id);
            Room createdClass = roomRepository.save(baseClass);
            return unitConverter.toDto(createdClass);
        }
        return unitConverter.toDto(baseClass);
    }
}
