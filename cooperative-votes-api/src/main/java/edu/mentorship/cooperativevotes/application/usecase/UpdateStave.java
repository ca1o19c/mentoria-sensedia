package edu.mentorship.cooperativevotes.application.usecase;

import edu.mentorship.cooperativevotes.application.dto.InputUpdateStaveDto;
import edu.mentorship.cooperativevotes.application.dto.StaveDto;
import edu.mentorship.cooperativevotes.structure.repository.StaveRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UpdateStave {

    private final ModelMapper modelMapper;

    private final StaveRepository staveRepository;

    public StaveDto update(String id, InputUpdateStaveDto inputUpdateStaveDto) {

        var staveOptional = staveRepository.findById(id);

        if (staveOptional.isEmpty())
            throw new RuntimeException();

        var entity = staveOptional.get();

        if (!entity.getTheme().equals(inputUpdateStaveDto.getTheme())) {
            var stave = staveRepository.existsStaveByThemeAndState(
                    inputUpdateStaveDto.getTheme(), "SESSION_VOTES_DONE");

            if (stave)
                throw new RuntimeException();
        }

        entity.setTheme(inputUpdateStaveDto.getTheme());
        entity.setDescription(inputUpdateStaveDto.getDescription());
        entity.updateAt();

        var staveUpdated = staveRepository.save(entity);

        return modelMapper.map(staveUpdated, StaveDto.class);
    }
}
