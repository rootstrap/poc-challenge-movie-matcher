import React from 'react';
import { Text } from 'react-native';

import AvatarPile from 'components/AvatarPile';
import Card from 'components/Card';
import GenreList from 'components/GenreList';
import Image from 'components/Image';
import MovieButtons from 'components/MovieButtons';
import View from 'components/View';

import { Movie } from 'types/index';

import styles from './styles';

type PropTypes = {
  movie: Movie;
  onPress: () => void;
};

const MovieCard: React.FunctionComponent<PropTypes> = ({ movie, onPress }) => {
  const uri = movie.poster_path || '';
  const title = movie.title || '-';
  const people = movie.recommended_by || [];
  const genres = movie.genres || [];
  return (
    <Card onPress={onPress}>
      <View style={styles.body}>
        <View style={styles.left}>
          <Image style={styles.image} source={{ uri }} resizeMode="cover" />
        </View>
        <View style={styles.right}>
          <Text style={styles.title}>{title}</Text>
          <GenreList genres={genres} />
          <AvatarPile people={people} />
        </View>
      </View>
      <View style={styles.footer}>
        <MovieButtons />
      </View>
    </Card>
  );
};

export default MovieCard;
