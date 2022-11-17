import React from 'react';
import { ScrollView, Text, View } from 'react-native';

import FlatList, { ListRenderItem, TItem } from 'components/FlatList';

import { Movie } from 'types/index';

import styles from './styles';

type PropTypes = { genres: Movie['genres'] };

const GenreList: React.FunctionComponent<PropTypes> = ({ genres }) => {
  const renderItem: ListRenderItem<string> = ({ item }) => (
    <View style={styles.listContainer}>
      <Text key={item} style={styles.genreText}>
        {item.toUpperCase()}
      </Text>
    </View>
  );

  const keyExtractor = (genre: string, index: number) => genre || String(index);
  return (
    <FlatList
      data={genres as TItem[]}
      keyExtractor={keyExtractor}
      renderItem={renderItem}
      horizontal
      keyboardShouldPersistTaps="handled"
      //  ItemSeparatorComponent={() => <ListItemSeparator />}
    />
  );
};

/* const GenreList: React.FunctionComponent<PropTypes> = ({ genres }) => {
  return (
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
}; */

export default GenreList;
