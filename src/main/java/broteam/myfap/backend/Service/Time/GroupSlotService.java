package broteam.myfap.backend.Service.Time;

import broteam.myfap.backend.Converter.Major.MajorConverter;
import broteam.myfap.backend.Dto.Major.MajorDto;
import broteam.myfap.backend.Dto.Major.MajorRequestDto;
import broteam.myfap.backend.Dto.Major.SubMajorRequestDto;
import broteam.myfap.backend.Dto.Time.GroupSlotDto;
import broteam.myfap.backend.Exception.NotFoundException;
import broteam.myfap.backend.Exception.Unit.SchoolException;
import broteam.myfap.backend.Models.Major.Major;
import broteam.myfap.backend.Models.Major.SubMajor;
import broteam.myfap.backend.Models.Time.GroupSlot;
import broteam.myfap.backend.Repository.Major.MajorRepository;
import broteam.myfap.backend.Repository.Major.SubMajorRepository;
import broteam.myfap.backend.Repository.Time.GroupSlotRepository;
import broteam.myfap.backend.Service.Major.IMajorService;
import broteam.myfap.backend.Service.Major.SubMajorService;
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
     private final MajorConverter majorConverter;
    private final ModelMapper modelMapper = new ModelMapper();

    @Override
    public List<GroupSlotDto> findAllBase() {
        List<GroupSlotDto> results = new ArrayList<>();
        for(GroupSlot school :  groupSlotRepository.findAll())
        {
            results.add(majorConverter.toDto(school));
        }
        return  results;
    }


}
