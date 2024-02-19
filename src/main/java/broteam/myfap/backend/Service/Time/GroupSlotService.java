package broteam.myfap.backend.Service.Time;

import broteam.myfap.backend.Converter.Time.SlotConverter;
import broteam.myfap.backend.Dto.Time.GroupSlotDto;
import broteam.myfap.backend.Dto.Time.GroupSlotRequestDto;
import broteam.myfap.backend.Exception.Unit.SchoolException;
import broteam.myfap.backend.Models.Time.GroupSlot;
import broteam.myfap.backend.Repository.Time.GroupSlotRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GroupSlotService implements IGroupSlotService {
    private final GroupSlotRepository groupSlotRepository;
     private final SlotConverter slotConverter;
    private final ModelMapper modelMapper = new ModelMapper();

    @Override
    public List<GroupSlotDto> findAllBase() {
        List<GroupSlotDto> results = new ArrayList<>();
        for(GroupSlot school :  groupSlotRepository.findAll())
        {
            results.add(slotConverter.toDto(school));
        }
        return  results;
    }

    @Transactional
    @Override
    public GroupSlotDto createNewGroup(GroupSlotRequestDto newGroup) {
        GroupSlot baseClass = modelMapper.map(newGroup, GroupSlot.class);

        Optional<GroupSlot> duplicate = groupSlotRepository.findByName(baseClass.getName());
        if (duplicate.stream().count() > 0) {
            throw new SchoolException("Set name is already used");
        }
        GroupSlot createdSet = groupSlotRepository.save(baseClass);
        return slotConverter.toDto(createdSet);
    }
}
