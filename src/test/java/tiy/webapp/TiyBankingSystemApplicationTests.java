package tiy.webapp;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.http.HttpSession;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = TiyBankingSystemApplication.class)
@WebAppConfiguration
public class TiyBankingSystemApplicationTests {

	@Autowired
	BankSystemController controller;

	@Autowired
	WebApplicationContext webapp;

	MockMvc mockMvc;

	@Before
	public void setup(){
		this.mockMvc = MockMvcBuilders.webAppContextSetup(webapp).build();
	}

	@Test
	public void contextLoads() {
	}

	@Test
	public void testHome() throws Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.get("/")
				.param("userid", "MMS1"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.model().attributeExists("bankList"))
				.andDo(MockMvcResultHandlers.print());
	}

}
