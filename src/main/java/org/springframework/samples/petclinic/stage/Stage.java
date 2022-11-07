package org.springframework.samples.petclinic.stage;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import org.springframework.samples.petclinic.enums.CurrentStage;
import org.springframework.samples.petclinic.model.BaseEntity;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "stages")
public class Stage extends BaseEntity{

    @Enumerated(EnumType.STRING)
    private CurrentStage currentStage;
}