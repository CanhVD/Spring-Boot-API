package org.example.project_java_nguyenduchoang.reponses.category;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.http.HttpStatus;

@Data//toString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseObject {
    @JsonProperty("message")
    private String message;

    @JsonProperty("error_Code")
    private Integer errorCode;

    @JsonProperty("data")
    private Object data;
}
