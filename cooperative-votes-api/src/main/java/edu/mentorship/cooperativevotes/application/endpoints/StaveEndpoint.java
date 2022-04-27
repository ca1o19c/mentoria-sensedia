package edu.mentorship.cooperativevotes.application.endpoints;

import edu.mentorship.cooperativevotes.application.api.StaveApi;
import edu.mentorship.cooperativevotes.application.dto.InputNewStaveDto;
import edu.mentorship.cooperativevotes.application.dto.InputUpdateStaveDto;
import edu.mentorship.cooperativevotes.application.dto.StaveDto;
import edu.mentorship.cooperativevotes.application.usecase.CreateStave;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping(value = "/staves")
@RequiredArgsConstructor
public class StaveEndpoint implements StaveApi {

    private final CreateStave createStave;

    @Override
    @PostMapping
    public ResponseEntity<StaveDto> create(InputNewStaveDto inputNewStaveDto) {
        var payload = createStave.create(inputNewStaveDto);

        return ResponseEntity
                .status(CREATED)
                .body(payload);
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<StaveDto> update(@PathVariable Long id, InputUpdateStaveDto inputUpdateStaveDto) {
        return StaveApi.super.update(id, inputUpdateStaveDto);
    }

    @Override
    @DeleteMapping
    public ResponseEntity<Void> cancel(Long id) {
        return StaveApi.super.cancel(id);
    }
}
