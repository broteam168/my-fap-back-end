package broteam.myfap.backend.Service.Major;

import broteam.myfap.backend.Converter.Unit.UnitConverter;
import broteam.myfap.backend.Dto.Unit.SchoolDto;
import broteam.myfap.backend.Repository.Unit.SchoolRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MajorService implements IMajorService{
    private final SchoolRepository schoolRepository;
    private final UnitConverter unitConverter;

    @Override
    public List<SchoolDto> findAllBase() {
        return null;
    }
}
