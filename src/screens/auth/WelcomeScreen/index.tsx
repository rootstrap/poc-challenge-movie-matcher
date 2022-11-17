import React, { useEffect, useState } from 'react';
import { NativeModules, SafeAreaView, StatusBar, Text, useColorScheme } from 'react-native';
import RNBootSplash from 'react-native-bootsplash';

import icon from 'assets/icon.png';

import FlatList, { ListRenderItem } from 'components/FlatList';
import Image from 'components/Image';
import ListItemSeparator from 'components/ListItemSeparator';
import MovieCard from 'components/MovieCard';
import View from 'components/View';

import { AppScreens, NativeStackScreenProps, StackParamList } from 'navigation/types';

import { Movie } from 'types/index';

import styles from './styles';

interface PropTypes extends NativeStackScreenProps<StackParamList, AppScreens.Welcome> {}

const { IntegrationModule } = NativeModules;

const WelcomeScreen: React.FunctionComponent<PropTypes> = () => {
  useEffect(() => {
    setTimeout(() => RNBootSplash.hide({ fade: true }), 3000);
    fetch('https://poc-movie-matcher-api.herokuapp.com/api/v1/movies')
      .then(response => response.json())
      .then(data => setMovies(data?.movies || []));
  }, []);

  const [movies, setMovies] = useState([]);
  const isDarkMode = useColorScheme() === 'dark';

  const renderItem: ListRenderItem<Movie> = ({ item }) => (
    <MovieCard movie={item} onPress={() => IntegrationModule.openDetailScreen(item)} />
  );

  const keyExtractor = ({ id }: Movie, index: number) => String(id) || String(index);

  return (
    <SafeAreaView style={styles.screenContainer}>
      <View style={styles.header} accessibilityRole="header">
        <Image source={icon} style={styles.headerIcon} accessibilityLabel="header icon" />
        <Text style={styles.headerTitle} accessibilityLabel="header title">
          movie<Text style={styles.bold}>matcher</Text>
        </Text>
      </View>
      <View style={styles.container}>
        <StatusBar barStyle={isDarkMode ? 'light-content' : 'dark-content'} />
        <FlatList
          data={movies}
          keyExtractor={keyExtractor}
          renderItem={renderItem}
          ItemSeparatorComponent={() => <ListItemSeparator />}
        />
      </View>
    </SafeAreaView>
  );
};

export default WelcomeScreen;
