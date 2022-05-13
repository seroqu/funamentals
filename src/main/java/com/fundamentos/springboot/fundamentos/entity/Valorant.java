package com.fundamentos.springboot.fundamentos.entity;
import javax.persistence.*;

@Entity
@Table(name = "valorant")
public class Valorant {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;

        private Integer type;

        public Integer getType() {
                return type;
        }

        public void setType(Integer type) {
                this.type = type;
        }

        public String getAgents() {
                return agents;
        }

        public void setAgents(String agents) {
                this.agents = agents;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        private String agents;
        private String name;

}
