package ua.murza.tdan.model.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class UpdateNoteRequest {
    private long id;
    private String title;
    private String text;
    private boolean important;
}
