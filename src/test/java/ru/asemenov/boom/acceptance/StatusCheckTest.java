package ru.asemenov.boom.acceptance;

import org.springframework.http.ResponseEntity;
import org.testng.annotations.Test;
import ru.asemenov.boom.common.ApplicationInfo;

import static org.springframework.http.HttpStatus.OK;
import static org.testng.Assert.assertEquals;
import static ru.asemenov.boom.Group.Acceptance;

/**
 * @author a.semenov
 */
public class StatusCheckTest extends AbstractAcceptanceTest {
    @Test(groups = Acceptance)
    public void test_SERVICE_IS_OK() {
        final ResponseEntity<ApplicationInfo> response = template.getForEntity(url("status"), ApplicationInfo.class);

        assertEquals(response.getStatusCode(), OK);
        assertEquals(response.getBody().getName(), "boom");
    }
}
