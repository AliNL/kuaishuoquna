package kuaishuoquna.web;

import kuaishuoquna.service.HelloService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.ui.ModelMap;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class HomeControllerTest {
    @Mock
    private HelloService helloService;

    @Before
    public void setUp() throws Exception {
        initMocks(this);
    }

    @Test
    public void shouldGetMessageFromHelloService() {
        final HomeController homeController = new HomeController(helloService);
        ModelMap modelMap = new ModelMap();

        final String message = "Hello";
        when(helloService.getGreeting()).thenReturn(message);

        homeController.displayMessage(modelMap);

//        assertEquals(message, modelMap.get("message"));
    }

}
