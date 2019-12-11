package com.parking.vehicle;

public  abstract class UniqueVechile implements Vehicle {

    //Depends only on account number
    @Override
    public int hashCode() {
        final int prime = 31;
        final int hash = 7;
        int result=1;
        for (int i = 0; i < getRegistrationNumber().length(); i++) {
            result = result + hash*prime + getRegistrationNumber().charAt(i);
        }

        return result;
    }

    //Compare only account numbers
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Vehicle other = (Vehicle) obj;
        return this.getRegistrationNumber().equals(other.getRegistrationNumber());
    }
}
