package broteam.myfap.backend.Service.Time;

import broteam.myfap.backend.Dto.Time.SessionDto;
import broteam.myfap.backend.Dto.Unit.ClassDto;
import broteam.myfap.backend.Models.Time.Session;
import broteam.myfap.backend.Repository.Time.SessionRepository;
import broteam.myfap.backend.Service.Unit.ClassService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SessionService implements ISessionService {
    private final SessionRepository sessionRepository;
     private final ModelMapper modelMapper = new ModelMapper();
    private final ClassService classService;
    @Override
    public List<SessionDto> findAllBase() {
        List<SessionDto> results = new ArrayList<>();
        for(Session session :  sessionRepository.findAll())
        {
            results.add(modelMapper.map(session, SessionDto.class));
        }
        return  results;
    }
    @Override
    public List<SessionDto> findBySchoolAndClass(Optional<Integer> schoolId, Optional<Integer> classid) {
        List<SessionDto> results = new ArrayList<>();

        if (schoolId.isEmpty()) {
            return findAllBase();

        } else {
            List<ClassDto> classes = classService.FindBySchoolId(schoolId.get());
            if (!classid.isEmpty()) {
                classes = classes.stream().filter(x -> x.getId() == classid.get()).toList();
            }
            for (ClassDto dto : classes) {
                List<Session> courses = sessionRepository.findByClassId(dto.getId());
                for (Session session : courses) {
                    results.add(modelMapper.map(session, SessionDto.class));
                }
            }
        }
        return results;
    }
}
