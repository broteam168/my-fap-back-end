package broteam.myfap.backend.Service.Time;

import broteam.myfap.backend.Converter.Time.SlotConverter;
import broteam.myfap.backend.Dto.Major.SubMajorDto;
import broteam.myfap.backend.Dto.Time.SlotDto;
import broteam.myfap.backend.Dto.Unit.ClassDto;
import broteam.myfap.backend.Dto.Unit.ClassRequest;
import broteam.myfap.backend.Exception.Unit.SchoolException;
import broteam.myfap.backend.Models.Major.SubMajor;
import broteam.myfap.backend.Models.Time.Slot;
import broteam.myfap.backend.Models.Unit.Class;
import broteam.myfap.backend.Repository.Time.SlotRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SlotService implements ISlotService {
    private final SlotRepository slotRepository;
     private final SlotConverter slotConverter;
    private final ModelMapper modelMapper = new ModelMapper();

    @Override
    public List<SlotDto> findAllBase() {
        List<SlotDto> results = new ArrayList<>();
        for(Slot slot :  slotRepository.findAll())
        {
            results.add(slotConverter.toDto(slot));
        }
        return  results;
    }
    @Override
    public List<SlotDto> FindByGroupId(int id) {
        List<SlotDto> results = new ArrayList<>();

        List<Slot> enitities = slotRepository.findByGroup(id);
        for(Slot enitity : enitities)
        {
            results.add(slotConverter.toDto(enitity));
        }
        return results;
    }
    @Transactional
    @Override
    public SlotDto createNewCLass(ClassRequest newCLass) {
        Class baseClass = modelMapper.map(newCLass, Class.class);

        Optional<Class> duplicate = classRepository.findByName(baseClass.getName());
        if (duplicate.stream().count() > 0) {
            throw new SchoolException("Class name is already used");
        }
        Class createdClass = classRepository.save(baseClass);
        return unitConverter.toDto(createdClass);
    }
}
