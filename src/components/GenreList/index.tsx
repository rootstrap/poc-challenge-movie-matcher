import React from 'react';
import { ScrollView, Text, View } from 'react-native';
import { Movie } from 'types/index';

import styles from './styles';

type PropTypes = { genres: Movie['genres'] };

const GenreList: React.FunctionComponent<PropTypes> = ({ genres }) => (
  <ScrollView horizontal>
    <View style={styles.listContainer}>
      {genres.map(genre => (
        <Text key={genre} style={styles.genreText}>
          {genre.toUpperCase()}
        </Text>
      ))}
    </View>
  </ScrollView>
);

export default GenreList;
