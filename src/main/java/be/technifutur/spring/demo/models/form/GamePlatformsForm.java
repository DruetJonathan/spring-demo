package be.technifutur.spring.demo.models.form;

import be.technifutur.spring.demo.models.entity.enums.Platform;
import lombok.Data;

import java.util.List;

@Data
public class GamePlatformsForm {
    private List<Platform> platforms;
}
