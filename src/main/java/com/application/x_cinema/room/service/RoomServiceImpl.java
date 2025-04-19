package com.application.x_cinema.room.service;

import com.application.x_cinema.cinema.entity.Cinema;
import com.application.x_cinema.common.enums.ErrorCode;
import com.application.x_cinema.common.exception.AppException;
import com.application.x_cinema.room.dto.request.RoomRequestDTO;
import com.application.x_cinema.room.dto.request.UpdateRoomDTO;
import com.application.x_cinema.room.dto.respone.RoomResponseDTO;
import com.application.x_cinema.room.entity.Room;
import com.application.x_cinema.room.mapper.RoomMapper;
import com.application.x_cinema.room.repository.RoomRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService {

    private final RoomRepository repository;

    private final RoomMapper mapper;

    @Override
    public Page<RoomResponseDTO> getByCinemaId(UUID cinemaId, Pageable pageable) {
        // Truy vấn dữ liệu tu id va pageable truyền vào tra ve page
        Page<Room> roomPage = repository.findByCinemaId(cinemaId, pageable);
        // Map từ page<Room> sang page<RoomResponseDTO>
        return roomPage.map(mapper::toResponse);
    }

    @Override
    public RoomResponseDTO create(RoomRequestDTO dto) {
        // Map from RoomRequestDTO sang Room
        Room room = mapper.toEntity(dto);
        // Lưu vào DB
        repository.save(room);
        // Map từ Room sang RoomResponseDTO roi tra ve
        return mapper.toResponse(room);
    }

    @Override
    public RoomResponseDTO update(UUID id, RoomRequestDTO dto) {
        // 1 Tim room theo id
        Room room = repository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.INTERNAL_ERROR));
        // 2 Cap nhat du lieu tu RoomRequestDTO vao Room dung mapper
        mapper.updateEntityFromDTO(dto, room);
        // 3 Lưu vào DB
        Room updatedRoom = repository.save(room);
        // 4 Map từ Room sang RoomResponseDTO roi tra ve
        return mapper.toResponse(updatedRoom);


    }

    @Override
    public RoomResponseDTO getById(UUID id) {
        // Tim room theo id va map tu Room sang RoomResponseDTO
        // Tra ve RoomResponseDTO hoac throw exception neu khong tim thay
        return repository.findById(id)
                .map(mapper::toResponse)
                .orElseThrow(() -> new AppException(ErrorCode.INTERNAL_ERROR));
    }

    @Override
    public Page<RoomResponseDTO> getAll(Pageable pageable) {
        // Truy vấn dữ liệu tu id va pageable truyền vào tra ve page
        Page<Room> roomPage = repository.findAll(pageable);
        // Map từ page<Room> sang page<RoomResponseDTO>
        return roomPage.map(mapper::toResponse);
    }

    @Override
    public void delete(UUID id) {
        repository.deleteById(id);
    }
}
