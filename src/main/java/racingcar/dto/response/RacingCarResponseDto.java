package racingcar.dto.response;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;

public class RacingCarResponseDto {

    private final String name;
    private final Integer position;

    private RacingCarResponseDto(final String name, final Integer position) {
        this.name = name;
        this.position = position;
    }

    public static List<RacingCarResponseDto> listOf(final List<Car> cars) {
        return cars.stream()
                .map(car -> new RacingCarResponseDto(car.getName(), car.getPosition()))
                .collect(Collectors.toList());
    }

    public String getName() {
        return name;
    }

    public Integer getPosition() {
        return position;
    }
}
