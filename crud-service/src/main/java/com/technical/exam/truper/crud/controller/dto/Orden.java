package com.technical.exam.truper.crud.controller.dto;

import java.time.LocalDate;

public record Orden(Long orden_id, LocalDate fecha, Double total) {}
