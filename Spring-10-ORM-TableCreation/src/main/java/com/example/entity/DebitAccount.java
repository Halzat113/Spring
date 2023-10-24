package com.example.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "debitaccount")
public class DebitAccount extends Account {
    private BigDecimal overDraftFee;
}
