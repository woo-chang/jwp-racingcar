package racingcar.dto.response;

import java.util.List;
import racingcar.domain.Car;

public class RacingGameResponseDto {

    private String winners;
    private List<RacingCarResponseDto> racingCars;

    private RacingGameResponseDto(final String winners, final List<RacingCarResponseDto> racingCars) {
        this.winners = winners;
        this.racingCars = racingCars;
    }

    public static RacingGameResponseDto of(final List<String> winners, final List<Car> cars) {
        return new RacingGameResponseDto(generateWinners(winners), RacingCarResponseDto.listOf(cars));
    }

    private static String generateWinners(final List<String> winners) {
        return String.join(",", winners);
    }

    public String getWinners() {
        return winners;
    }

    public List<RacingCarResponseDto> getRacingCars() {
        return racingCars;
    }
}
