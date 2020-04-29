package com.launchacademy.pettracker.models;

import static javax.persistence.CascadeType.ALL;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="species")
@Getter
@Setter
@NoArgsConstructor
public class Species {
  @Id
  @SequenceGenerator(name="species_generator", sequenceName="species_id_seq", allocationSize = 1)
  @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="species_generator")
  @Column(name="id", nullable=false, unique=true)
  private Integer id;

  @OneToMany(mappedBy = "species")
  private List<Species> species;

  @Column(name="type")
  @NotBlank
  private String type;

  @Column(name="description")
  private String description;

}