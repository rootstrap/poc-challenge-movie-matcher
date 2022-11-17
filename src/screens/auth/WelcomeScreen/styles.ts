import { StyleSheet } from 'react-native';

import { SCREEN_BACKGROUND, WHITE } from 'constants/colors';

export default StyleSheet.create({
  screenContainer: {
    flex: 1,
    backgroundColor: WHITE,
  },
  header: {
    alignItems: 'center',
    backgroundColor: '#260065',
    flexDirection: 'row',
    height: 56,
    paddingHorizontal: 26,
  },
  headerIcon: {
    marginRight: 19,
  },
  headerTitle: {
    color: 'white',
  },
  bold: {
    fontWeight: 'bold',
  },
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
    backgroundColor: SCREEN_BACKGROUND,
  },
});
