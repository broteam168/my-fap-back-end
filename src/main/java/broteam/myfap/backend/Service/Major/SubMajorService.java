package broteam.myfap.backend.Service.Major;

import broteam.myfap.backend.Converter.Major.MajorConverter;
import broteam.myfap.backend.Dto.Major.SubMajorDto;
import broteam.myfap.backend.Dto.Major.SubMajorRequestDto;
import broteam.myfap.backend.Exception.Unit.SchoolException;
import broteam.myfap.backend.Models.Major.SubMajor;
import broteam.myfap.backend.Repository.Major.SubMajorRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    @Transactional
    @Override
    public SubMajorDto createNewSubMajor(SubMajorRequestDto newSubMajor) {

        SubMajor base = majorConverter.toEnity(newSubMajor);

        Optional<SubMajor> duplicate = subMajorRepository.findByName(base.getName());
        if (duplicate.stream().count() > 0) {
            throw new SchoolException("MSubMajor name is already used");
        }
        SubMajor createdSubMajor = subMajorRepository.save(base);
        return majorConverter.toDto(createdSubMajor);
    }

}
