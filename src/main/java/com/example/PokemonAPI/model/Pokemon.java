package com.example.PokemonAPI.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.URL;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Pokemon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre del pokemon es obligatorio")
    @Size(min=2, max=100, message = " El nombre debe tener entre 2 y 100 caracteres")
    private String nombre;

    @NotBlank(message = "El tipo de pokemon es obligatorio")
    private String tipo;

    @NotNull(message = "El nivel del pokemon es obligatorio")
    @Min(value = 0, message = "El nivel no puede ser negativo")
    @Max(value = 100, message = "El nivel no puede ser mayor a 100")
    private Integer nivel;

    @NotNull(message = "El ataque del pokemon es obligatorio")
    @Min(value = 0, message = "El ataque no puede ser negativa")
    @Max(value = 526, message = "El ataque no puede ser mayor a 526")
    private Integer ataque;

    @NotNull(message = "La defensa del pokemon es obligatorio")
    @Min(value = 0, message = "La defensa no puede ser negativa")
    @Max(value = 614, message = "La defensa no puede ser mayor a 614")
    private Integer defensa;

    @Size(max = 255, message = "La descripción no puede exceder los 255 caracteres")
    private String descripcion;

    @URL(message = "La imagen debe ser una URL")
    private String imagen_url;

    //puro ejemplo para ver más ejemplos

    @Email(message = "El formato del correo no es valido")
    private String correoEntrenador;

    @PastOrPresent(message = "La fecha de captura no puede ser futura")
    private LocalDate fechaCaptura;

    @Positive(message = "El peso debe ser positivo ")
    private Double peso;

    @Pattern(regexp = "^\\+(?:[0-9] ?){6,14}[0-9]$", message = "El formato el telefono no es valido")
    private String telefonoEntrenador;

    @AssertTrue(message = "El pokemon debe estar sano")
    private boolean estaSano;


}
