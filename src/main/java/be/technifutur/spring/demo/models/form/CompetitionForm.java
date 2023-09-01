package be.technifutur.spring.demo.models.form;

import be.technifutur.spring.demo.models.entity.Address;
import be.technifutur.spring.demo.models.entity.Competition;
import be.technifutur.spring.demo.models.entity.DistributionMode;
import be.technifutur.spring.demo.models.entity.Game;
import be.technifutur.spring.demo.validation.contraints.MinSmallerMax;
import be.technifutur.spring.demo.validation.contraints.SequentialDate;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
@MinSmallerMax @SequentialDate
public class CompetitionForm {

    @NotBlank
    @Size(min = 5,max = 100)
    private String name;

    @Min(2)
    private int minPlayer = 2;

    @Min(2)
    private int maxPlayer = 16;

    @NotNull
    private LocalDate inscriptionStart;

    @NotNull
    private LocalDate inscriptionEnd;

    @NotNull
    private LocalDate competitionStart;

    @NotNull
    private LocalDate competitionEnd;

    private double entry;

    private double cashPrice;

    private DistributionMode distributionMode;

    @Valid
    private AddressForm address;

    public Competition toEntity(){

        Competition competition = new Competition();
        competition.setName(this.name);
        competition.setMinPlayer(this.minPlayer);
        competition.setMaxPlayer(this.maxPlayer);
        competition.setInscriptionStart(this.inscriptionStart);
        competition.setInscriptionEnd(this.inscriptionEnd);
        competition.setCompetitionStart(this.competitionStart);
        competition.setCompetitionEnd(this.competitionEnd);
        competition.setEntry(this.entry);
        competition.setCashPrice(this.cashPrice);
        competition.setDistributionMode(this.distributionMode);
        competition.setAddress(this.address.toEntity());

        return competition;
    }
}
