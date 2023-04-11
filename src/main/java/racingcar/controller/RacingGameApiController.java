package racingcar.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import racingcar.domain.Cars;
import racingcar.domain.Count;
import racingcar.domain.RacingGame;
import racingcar.domain.RandomNumberGenerator;
import racingcar.dto.request.RacingGameRequestDto;
import racingcar.dto.response.RacingGameResponseDto;

@RestController
public class RacingGameApiController {

    @PostMapping(value = "/plays")
    public RacingGameResponseDto plays(@RequestBody RacingGameRequestDto racingGameRequestDto) {
        final RacingGame racingGame = generateGame(racingGameRequestDto);
        while (racingGame.isPlayable()) {
            racingGame.play();
        }
        return RacingGameResponseDto.of(racingGame.findWinners(), racingGame.getCurrentResult());
    }

    private RacingGame generateGame(final RacingGameRequestDto racingGameRequestDto) {
        final Cars cars = new Cars(generateCarNames(racingGameRequestDto.getNames()));
        final Count count = new Count(racingGameRequestDto.getCount());
        return new RacingGame(new RandomNumberGenerator(), cars, count);
    }

    private List<String> generateCarNames(final String names) {
        return Arrays.stream(names.split(","))
                .collect(Collectors.toList());
    }
}
