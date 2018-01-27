package ru.asemenov.boom;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.asemenov.boom.common.ApplicationInfo;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * @author a.semenov
 */
@Controller
public class MainController {
    @Value("${application.version}")
    private String version;

    @RequestMapping(value = "/status", method = GET)
    public ResponseEntity<ApplicationInfo> status() {
        return new ResponseEntity<>(new ApplicationInfo("boom", version), HttpStatus.OK);
    }
}
