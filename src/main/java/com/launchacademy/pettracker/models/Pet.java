package com.launchacademy.pettracker.models;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="pets")
@Getter
@Setter
@NoArgsConstructor
public class Pet {
  @Id
  @SequenceGenerator(name="pet_generator", sequenceName="pets_id_seq", allocationSize = 1)
  @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="pet_generator")
  @Column(name="id", nullable=false, unique=true)
  private Integer id;

  @NotBlank
  @Size(max=20)
  @Column
  private String name;

  @NotBlank
  @Size(max=10)
  @Pattern(regexp = "^([^0-9]*)$", message = "must not contain numbers")
  @Column
  private String species;

  @NotBlank
  @Size(max=15)
  @Pattern(regexp = "^([^0-9]*)$", message = "must not contain numbers")
  @Column
  private String breed;

  @Min(1)
  @Max(999)
  @NotNull
  @Column
  private Integer age;

  @NotNull
  @Column
  private boolean fixed;
}
