package br.com.jhon.VacinacaoZup.config.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import br.com.jhon.VacinacaoZup.config.Response.ErroValidacaoResponse;
import br.com.jhon.VacinacaoZup.config.Response.ExceptionResponse;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestControllerAdvice
public class ExceptionHandlerCustomized {

    @Autowired
    private MessageSource messageSource;

    @ExceptionHandler({DataIntegrityViolationException.class})
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ErroValidacaoResponse handleAll(DataIntegrityViolationException ex, WebRequest webRequest) {
        String message = ex.getMessage();
        String campo = webRequest.getDescription(false);
        if (ex.getMessage().contains("email_uk")) {
            message = "E-mail já cadastrado!";
            campo = "email";
        }
        if (ex.getMessage().contains("cpf_uk")) {
            message = "CPF já cadastrado!";
            campo = "cpf";
        }
        return new ErroValidacaoResponse(campo,message);
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public List<ErroValidacaoResponse> handle(MethodArgumentNotValidException exception){
        List<ErroValidacaoResponse> dto = new ArrayList<>();
        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
        fieldErrors.forEach(e -> {
            String mensagem = messageSource.getMessage(e, LocaleContextHolder.getLocale());
            ErroValidacaoResponse erro = new ErroValidacaoResponse(e.getField(), mensagem);
            dto.add(erro);
        });
        return dto;
    }

    @ExceptionHandler({Exception.class})
    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
    public ExceptionResponse handleAll(Exception ex, WebRequest webRequest){
        return new ExceptionResponse(
                new Date(),
                ex.getMessage(),
                webRequest.getDescription(false));
    }
}
