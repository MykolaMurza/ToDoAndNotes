package ua.murza.tdan.model.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class DeleteNoteRequest {
    private long id;
    private boolean byQueue;
}
