package com.example.data.service.seviceImplement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.data.entity.PlaylistEntity;
import com.example.data.entity.SongEntity;
import com.example.data.model.PlaylistDTO;
import com.example.data.model.SongDTO;
import com.example.data.model.converter.PlaylistConverter;
import com.example.data.model.converter.SongConverter;
import com.example.data.repository.PlaylistRepository;
import com.example.data.repository.SongRepository;
import com.example.data.service.PlaylistService;

@Service
public class PlaylistServiceImplement implements PlaylistService {

    private PlaylistRepository playlistRepository;
    private SongRepository songRepository;

    @Autowired
    PlaylistServiceImplement(PlaylistRepository playlistRepository, SongRepository songRepository) {
        this.playlistRepository = playlistRepository;
        this.songRepository = songRepository;
    }

    @Override
    public List<PlaylistDTO> getAllPlaylist() {
        List<PlaylistEntity> playlistEntities = playlistRepository.findAll();

        return PlaylistConverter.toDTOList(playlistEntities);
    }

    @Override
    public List<PlaylistDTO> getAllByUserId(Integer userId) {
        List<PlaylistEntity> playlistEntity = playlistRepository.findByUserId(userId);

        return PlaylistConverter.toDTOList(playlistEntity);
    }

    @Override
    public PlaylistDTO getPlaylistById(Integer playlistId) {
        PlaylistEntity playlistEntity = playlistRepository.findById(playlistId).get();

        return PlaylistConverter.toDTO(playlistEntity);
    }

    @Override
    public List<SongDTO> getSongsByPlaylistId(Integer playlistId) {
        List<SongEntity> songEntities = playlistRepository.findSongsByPlaylistId(playlistId);

        return SongConverter.convertToDTOList(songEntities);
    }

    @Override
    public void savePlaylist(PlaylistDTO playlistDTO) {
        PlaylistEntity playlistEntity = PlaylistConverter.toEntity(playlistDTO);

        playlistRepository.save(playlistEntity);
    }

    @Override
    public void deletePlaylist(Integer playlistId) {
        playlistRepository.deleteById(playlistId);
    }

    @Override
    public void addSongToPlaylist(Integer playlistId, Integer songId) {
        PlaylistEntity playlistEntity = playlistRepository.findById(playlistId).get();
        SongEntity songEntity = songRepository.findById(songId).get();

        playlistEntity.getSongs().add(songEntity);

        playlistRepository.save(playlistEntity);
    }

    @Override
    public void removeSongFromPlaylist(Integer playlistId, Integer songId) {
        PlaylistEntity playlistEntity = playlistRepository.findById(playlistId).get();
        SongEntity songEntity = songRepository.findById(songId).get();

        playlistEntity.getSongs().remove(songEntity);

        playlistRepository.save(playlistEntity);
    }
    
}
