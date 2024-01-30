package broteam.myfap.backend.Service.Major;

import broteam.myfap.backend.Converter.Major.MajorConverter;
import broteam.myfap.backend.Dto.Major.MajorDto;
import broteam.myfap.backend.Dto.Major.MajorRequestDto;
import broteam.myfap.backend.Exception.Unit.SchoolException;
import broteam.myfap.backend.Models.Unit.Major;
import broteam.myfap.backend.Repository.Major.MajorRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MajorService implements IMajorService{
    private final MajorRepository majorRepository;
    private final MajorConverter majorConverter;
    private final ModelMapper modelMapper = new ModelMapper();


    @Override
    public List<MajorDto> findAllBase() {
        List<MajorDto> results = new ArrayList<>();
        for(Major school :  majorRepository.findAll())
        {
            results.add(majorConverter.toDto(school));
        }
        return  results;
    }
    @Transactional
    @Override
    public MajorDto createNewMajor(MajorRequestDto newCLass) {

        Major base = modelMapper.map(newCLass, Major.class);

        Optional<Major> duplicate = majorRepository.findByName(base.getName());
        if (duplicate.stream().count() > 0) {
            throw new SchoolException("Major name is already used");
        }
        Major createdClass = majorRepository.save(base);
        return majorConverter.toDto(createdClass);
    }
}
