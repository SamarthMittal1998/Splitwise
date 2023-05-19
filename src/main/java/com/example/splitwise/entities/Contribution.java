package com.example.splitwise.entities;

import lombok.*;

/**
 * Created by samarthMittal
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Contribution  extends SuperEntity {

    private Double shareAmount;
    private Double sharePercentage;

}
