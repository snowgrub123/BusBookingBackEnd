package com.devteria.identityservice.entity;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.sql.Time;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ChuyenXe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    float distance;
    String departure;
    String destination;



    @OneToMany(mappedBy = "chuyenXe",cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JsonManagedReference
    List<Bus> bus;
    @OneToMany(mappedBy = "chuyenXe")
    private List<BusTicket> tickets;

    @ManyToMany
    @JoinTable(
            name = "chuyenxe_allcode",
            joinColumns = @JoinColumn(name = "chuyenxe_id"),
            inverseJoinColumns = @JoinColumn(name = "allcode_id")
    )
    private Set<AllCode> allCodes;

    public void addBus(Bus buses) {
        bus.add(buses);
        buses.setChuyenXe(this);
    }
//    public void removeBus(Bus bus) {
//        buses.remove(bus);
//        bus.setChuyenXe(null);
//    }

}
