package racingcar.dao;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootTest
class RacingGameDaoTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @DisplayName("자동차 게임 정보를 저장한다.")
    @Test
    void save() {
        final RacingGameDao racingGameDao = new RacingGameDao(jdbcTemplate);

        final Long id = racingGameDao.save("루쿠", 10);

        assertThat(id).isNotNull();
    }
}
