import icon from 'assets/icon.png';
import React, { useEffect, useState } from 'react';
import {
  NativeModules,
  SafeAreaView,
  StatusBar,
  Text,
  TouchableOpacity,
  View,
  useColorScheme,
} from 'react-native';
import RNBootSplash from 'react-native-bootsplash';

import Image from 'components/Image';

import { AppScreens, NativeStackScreenProps, StackParamList } from 'navigation/types';

import styles from './styles';

interface PropTypes extends NativeStackScreenProps<StackParamList, AppScreens.Welcome> {}

const { IntegrationModule } = NativeModules;

const WelcomeScreen: React.FunctionComponent<PropTypes> = () => {
  const [movies, setMovies] = useState([]);
  const isDarkMode = useColorScheme() === 'dark';

  const openDetailScreen = () => {
    IntegrationModule.openDetailScreen();
  };

  useEffect(() => {
    setTimeout(() => RNBootSplash.hide({ fade: true }), 3000);
    fetch('https://poc-movie-matcher-api.herokuapp.com/api/v1/movies')
      .then(response => response.json())
      .then(data => setMovies(data));
  }, []);

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
        <Text accessibilityRole={'text'}>Welcome Screen</Text>
        <TouchableOpacity
          onPress={openDetailScreen}
          testID="dummy-button"
          accessibilityState={{ disabled: false }}
          accessibilityRole={'button'}>
          <Text>Dummy Button</Text>
        </TouchableOpacity>
      </View>
    </SafeAreaView>
  );
};

export default WelcomeScreen;
