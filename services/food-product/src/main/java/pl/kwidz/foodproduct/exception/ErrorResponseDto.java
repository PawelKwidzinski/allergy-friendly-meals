package pl.kwidz.foodproduct.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Setter
public class ErrorResponseDto {

    private  String apiPath;
    private HttpStatus errorCode;
    private  String errorMessage;
    private LocalDateTime errorTime;
}
