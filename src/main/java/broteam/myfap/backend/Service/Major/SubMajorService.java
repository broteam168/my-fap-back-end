package broteam.myfap.backend.Service.Major;

import broteam.myfap.backend.Converter.Major.MajorConverter;
import broteam.myfap.backend.Dto.Major.MajorDto;
import broteam.myfap.backend.Dto.Major.SubMajorDto;
import broteam.myfap.backend.Models.Major.Major;
import broteam.myfap.backend.Models.Major.SubMajor;
import broteam.myfap.backend.Repository.Major.MajorRepository;
import broteam.myfap.backend.Repository.Major.SubMajorRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SubMajorService implements  ISubMajorService{
    private final SubMajorRepository subMajorRepository;
    private final MajorConverter majorConverter;
    private final ModelMapper modelMapper = new ModelMapper();


    @Override
    public List<SubMajorDto> findAllBase() {
        List<SubMajorDto> results = new ArrayList<>();
        for(SubMajor subMajorDto :  subMajorRepository.findAll())
        {
            results.add(majorConverter.toDto(subMajorDto));
        }
        return  results;
    }
}
