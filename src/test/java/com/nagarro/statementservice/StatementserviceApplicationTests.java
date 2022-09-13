package com.nagarro.statementservice;

import com.nagarro.statementservice.core.usecases.AccountService;
import com.nagarro.statementservice.core.usecases.StatementService;
import com.nagarro.statementservice.infrastructure.controllers.AccountController;
import com.nagarro.statementservice.infrastructure.controllers.StatementController;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@ExtendWith(MockitoExtension.class)
class StatementserviceApplicationTests {

	@Mock
	private AccountController accountController;

	@Mock
	private StatementController statementController;

	@Mock
	private AccountService accountService;

	@Mock
	private StatementService statementService;

	@Test
	void contextLoads() {
		assertThat(accountController).isNotNull();
		assertThat(statementController).isNotNull();
		assertThat(accountService).isNotNull();
		assertThat(statementService).isNotNull();
	}

}
