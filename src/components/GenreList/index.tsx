import React from 'react';
import { ScrollView, Text, View } from 'react-native';

import styles from './styles';

const GenreList = ({ genres }) => (
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
