package hello.itemservice.web.validation;

import hello.itemservice.web.validation.form.ItemSaveForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/validation/api/items")
public class ValidationItemApiController {

    //@ResponseBody 묵시적 추가
    @PostMapping("/add")
    public Object addItem(
            @RequestBody @Validated ItemSaveForm form,
            BindingResult bindingResult
    ) {
        log.info("addItem API 컨트롤러 호출됨");

        if (bindingResult.hasErrors()) {
            log.info("검증 오류 발생 = {}", bindingResult);
            return bindingResult.getAllErrors(); //FieldError, ObjectError 모두 JSON 형태로 반환
        }

        log.info("검증 성공에 따른 로직 실행");
        return form;
    }
}