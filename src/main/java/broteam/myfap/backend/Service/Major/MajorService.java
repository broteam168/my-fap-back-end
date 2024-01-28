package broteam.myfap.backend.Service.Major;

import broteam.myfap.backend.Converter.Major.MajorConverter;
import broteam.myfap.backend.Converter.Unit.UnitConverter;
import broteam.myfap.backend.Dto.Major.MajorDto;
import broteam.myfap.backend.Dto.Unit.SchoolDto;
import broteam.myfap.backend.Models.Unit.Major;
import broteam.myfap.backend.Models.Unit.School;
import broteam.myfap.backend.Repository.Major.MajorRepository;
import broteam.myfap.backend.Repository.Unit.SchoolRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MajorService implements IMajorService{
    private final MajorRepository majorRepository;
    private final MajorConverter majorConverter;

    @Override
    public List<MajorDto> findAllBase() {
        List<MajorDto> results = new ArrayList<>();
        for(Major school :  majorRepository.findAll())
        {
            results.add(majorConverter.toDto(school));
        }
        return  results;
    }
}
