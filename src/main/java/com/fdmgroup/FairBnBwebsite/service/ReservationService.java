package com.fdmgroup.FairBnBwebsite.service;

import java.util.List;

import com.fdmgroup.FairBnBwebsite.model.Reservation;

public interface ReservationService {

	Reservation getReservationById(int reservationId);

	Reservation createReservation();

	Reservation editReservation(Reservation reservation);

	Reservation saveReservation(Reservation reservation);

	List<Reservation> getAllReservations();

	void deleteReservation(Reservation reservation);

	void deleteRedervationById(int reservationId);

}
